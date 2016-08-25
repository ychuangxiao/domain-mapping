/**
 * Copyright (C) 2010-2014 eBusiness Information, Excilys Group
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.banditcat.android.transformer.compiler.process;

import com.banditcat.android.transformer.compiler.exception.ProcessingException;
import com.banditcat.android.transformer.compiler.handler.AnnotationHandler;
import com.banditcat.android.transformer.compiler.handler.AnnotationHandlers;
import com.banditcat.android.transformer.compiler.handler.GeneratingAnnotationHandler;
import com.banditcat.android.transformer.compiler.holder.GeneratedClassHolder;
import com.banditcat.android.transformer.compiler.model.AnnotationElements;
import com.banditcat.android.transformer.compiler.model.OriginatingElements;
import com.sun.codemodel.JCodeModel;


import java.util.Set;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;


public class ModelProcessor {
    Messager mMessager;

    public static class ProcessResult {

        public final JCodeModel codeModel;
        public final OriginatingElements originatingElements;


        public ProcessResult(//
                             JCodeModel codeModel, //
                             OriginatingElements originatingElements) {

            this.codeModel = codeModel;
            this.originatingElements = originatingElements;

        }
    }

    private final ProcessingEnvironment processingEnv;
    private final AnnotationHandlers annotationHandlers;

    public ModelProcessor(Messager messager, ProcessingEnvironment processingEnv, AnnotationHandlers annotationHandlers) {
        this.mMessager = messager;
        this.processingEnv = processingEnv;
        this.annotationHandlers = annotationHandlers;
    }


    public ProcessResult process(AnnotationElements validatedModel) throws Exception {
        ProcessHolder processHolder = new ProcessHolder(processingEnv);

        annotationHandlers.setProcessHolder(processHolder);
        //处理Class
        mMessager.printMessage(Diagnostic.Kind.NOTE,
                "Processing root elements");

		/*
         * We generate top classes then inner classes, then inner classes of inner classes, etc...
		 * until there is no more classes to generate.
		 */
        generateElements(validatedModel, processHolder);

        for (AnnotationHandler annotationHandler : annotationHandlers.getDecorating()) {
            String annotationName = annotationHandler.getTarget();

			/*
             * For ancestors, the annotationHandler manipulates the annotated
			 * elements, but uses the holder for the root element
			 */
            Set<AnnotationElements.AnnotatedAndRootElements> ancestorAnnotatedElements = validatedModel.getAncestorAnnotatedElements(annotationName);

            if (!ancestorAnnotatedElements.isEmpty()) {
                mMessager.printMessage(Diagnostic.Kind.NOTE,
                        String.format("Processing root elements %s: %s", ancestorAnnotatedElements.getClass().getSimpleName(), annotationHandler));
            }

            for (AnnotationElements.AnnotatedAndRootElements elements : ancestorAnnotatedElements) {


                GeneratedClassHolder holder = processHolder.getGeneratedClassHolder(elements.rootTypeElement);
                if (holder != null) {
                    processThrowing(annotationHandler, elements.annotatedElement, holder);
                }
            }

            Set<? extends Element> rootAnnotatedElements = validatedModel.getRootAnnotatedElements(annotationName);

            for (Element annotatedElement : rootAnnotatedElements) {

                Element enclosingElement;
                if (annotatedElement instanceof TypeElement) {
                    enclosingElement = annotatedElement;
                } else {
                    enclosingElement = annotatedElement.getEnclosingElement();
                }

				 /*
                 * We do not generate code for elements belonging to abstract
				 * classes, because the generated classes are final anyway
				 */
                if (!isAbstractClass(enclosingElement)) {
                    GeneratedClassHolder holder = processHolder.getGeneratedClassHolder(enclosingElement);
                    processThrowing(annotationHandler, annotatedElement, holder);

                }
            }

        }
        return new ProcessResult(//
                processHolder.codeModel(), //
                processHolder.getOriginatingElements());
    }


    private boolean generateElements(AnnotationElements validatedModel
            , ProcessHolder processHolder) throws Exception {

        for (GeneratingAnnotationHandler generatingAnnotationHandler : annotationHandlers.getGenerating()) {

            //获取类的全名
            String annotationName = generatingAnnotationHandler.getTarget();


            mMessager.printMessage(Diagnostic.Kind.NOTE,
                    "注解信息" + annotationName + "  .... ");


            //获取top class
            Set<? extends Element> annotatedElements = validatedModel.getRootAnnotatedElements(annotationName);

            if (!annotatedElements.isEmpty()) {
                mMessager.printMessage(Diagnostic.Kind.NOTE,
                        String.format("Processing root elements %s: %s", generatingAnnotationHandler.getClass().getSimpleName(), annotatedElements));

            }


            //循环处理Top Class
            for (Element annotatedElement : annotatedElements) {
               /*
                * We do not generate code for abstract classes, because the
                * generated classes are final anyway (we do not want anyone to
                * extend them).
                */

                if (!isAbstractClass(annotatedElement)) {

                    //判断当前元素是否已经处理过
                    if (processHolder.getGeneratedClassHolder(annotatedElement) == null) {

                        TypeElement typeElement = (TypeElement) annotatedElement;
                        Element enclosingElement = annotatedElement.getEnclosingElement();

                        if (typeElement.getNestingKind() == NestingKind.MEMBER && processHolder.getGeneratedClassHolder(enclosingElement) == null) {
                            break;
                        } else {
                            GeneratedClassHolder generatedClassHolder = generatingAnnotationHandler.createGeneratedClassHolder(processHolder, typeElement);
                            processHolder.put(annotatedElement, generatedClassHolder);
                            generatingAnnotationHandler.process(annotatedElement, generatedClassHolder);
                        }
                    }

                } else {
                    mMessager.printMessage(Diagnostic.Kind.NOTE,
                            String.format("Skip element %s because it's abstract", annotatedElements));


                }
            }


        }
        return false;
    }

    private <T extends GeneratedClassHolder> void processThrowing(AnnotationHandler<T> handler, Element element, T generatedClassHolder) throws ProcessingException {
        try {
            handler.process(element, generatedClassHolder);
        } catch (Exception e) {
            throw new ProcessingException(e, element);
        }
    }

    private boolean isAbstractClass(Element annotatedElement) {
        return false;
    }
}
