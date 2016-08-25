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

import com.banditcat.android.transformer.compiler.helper.CanonicalNameConstants;
import com.banditcat.android.transformer.compiler.holder.GeneratedClassHolder;
import com.banditcat.android.transformer.compiler.model.OriginatingElements;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

public class ProcessHolder {

    public class Classes {

        /*
         * Java
         */
        public final JClass RUNTIME_EXCEPTION = refClass(RuntimeException.class);
        public final JClass EXCEPTION = refClass(Exception.class);
        public final JClass THROWABLE = refClass(Throwable.class);
        public final JClass CHAR_SEQUENCE = refClass(CharSequence.class);
        public final JClass CLASS_CAST_EXCEPTION = refClass(ClassCastException.class);
        public final JClass SERIALIZABLE = refClass(Serializable.class);
        public final JClass STRING = refClass(String.class);
        public final JClass STRING_BUILDER = refClass(StringBuilder.class);
        public final JClass SYSTEM = refClass(System.class);
        public final JClass INPUT_STREAM = refClass(InputStream.class);
        public final JClass FILE_INPUT_STREAM = refClass(FileInputStream.class);
        public final JClass SQL_EXCEPTION = refClass(SQLException.class);
        public final JClass COLLECTIONS = refClass(Collections.class);
        public final JClass THREAD = refClass(Thread.class);
        public final JClass HASH_MAP = refClass(HashMap.class);
        public final JClass LIST = refClass(List.class);
        public final JClass OBJECT = refClass(Object.class);
        public final JClass ARRAYS = refClass(Arrays.class);

        /*
         * Android
         */
        public final JClass LOG = refClass(CanonicalNameConstants.LOG);
        public final JClass BUNDLE = refClass(CanonicalNameConstants.BUNDLE);
        public final JClass ACTIVITY = refClass(CanonicalNameConstants.ACTIVITY);
        public final JClass EDITABLE = refClass(CanonicalNameConstants.EDITABLE);
        public final JClass TEXT_WATCHER = refClass(CanonicalNameConstants.TEXT_WATCHER);
        public final JClass SEEKBAR = refClass(CanonicalNameConstants.SEEKBAR);
        public final JClass ON_SEEKBAR_CHANGE_LISTENER = refClass(CanonicalNameConstants.ON_SEEKBAR_CHANGE_LISTENER);
        public final JClass TEXT_VIEW = refClass(CanonicalNameConstants.TEXT_VIEW);
        public final JClass TEXT_VIEW_ON_EDITOR_ACTION_LISTENER = refClass(CanonicalNameConstants.TEXT_VIEW_ON_EDITOR_ACTION_LISTENER);
        public final JClass COMPOUND_BUTTON = refClass(CanonicalNameConstants.COMPOUND_BUTTON);
        public final JClass COMPOUND_BUTTON_ON_CHECKED_CHANGE_LISTENER = refClass(CanonicalNameConstants.COMPOUND_BUTTON_ON_CHECKED_CHANGE_LISTENER);
        public final JClass VIEW = refClass(CanonicalNameConstants.VIEW);
        public final JClass VIEW_ON_CLICK_LISTENER = refClass(CanonicalNameConstants.VIEW_ON_CLICK_LISTENER);
        public final JClass VIEW_ON_TOUCH_LISTENER = refClass(CanonicalNameConstants.VIEW_ON_TOUCH_LISTENER);
        public final JClass VIEW_ON_LONG_CLICK_LISTENER = refClass(CanonicalNameConstants.VIEW_ON_LONG_CLICK_LISTENER);
        public final JClass VIEW_ON_FOCUS_CHANGE_LISTENER = refClass(CanonicalNameConstants.VIEW_ON_FOCUS_CHANGE_LISTENER);
        public final JClass VIEW_GROUP_LAYOUT_PARAMS = refClass(CanonicalNameConstants.VIEW_GROUP_LAYOUT_PARAMS);
        public final JClass KEY_EVENT = refClass(CanonicalNameConstants.KEY_EVENT);
        public final JClass CONTEXT = refClass(CanonicalNameConstants.CONTEXT);
        public final JClass INTENT = refClass(CanonicalNameConstants.INTENT);
        public final JClass INTENT_FILTER = refClass(CanonicalNameConstants.INTENT_FILTER);
        public final JClass BROADCAST_RECEIVER = refClass(CanonicalNameConstants.BROADCAST_RECEIVER);
        public final JClass LOCAL_BROADCAST_MANAGER = refClass(CanonicalNameConstants.LOCAL_BROADCAST_MANAGER);
        public final JClass COMPONENT_NAME = refClass(CanonicalNameConstants.COMPONENT_NAME);
        public final JClass VIEW_GROUP = refClass(CanonicalNameConstants.VIEW_GROUP);
        public final JClass LAYOUT_INFLATER = refClass(CanonicalNameConstants.LAYOUT_INFLATER);
        public final JClass FRAGMENT_ACTIVITY = refClass(CanonicalNameConstants.FRAGMENT_ACTIVITY);
        public final JClass FRAGMENT = refClass(CanonicalNameConstants.FRAGMENT);
        public final JClass SUPPORT_V4_FRAGMENT = refClass(CanonicalNameConstants.SUPPORT_V4_FRAGMENT);
        public final JClass HTML = refClass(CanonicalNameConstants.HTML);
        public final JClass WINDOW_MANAGER_LAYOUT_PARAMS = refClass(CanonicalNameConstants.WINDOW_MANAGER_LAYOUT_PARAMS);
        public final JClass ADAPTER_VIEW = refClass(CanonicalNameConstants.ADAPTER_VIEW);
        public final JClass ON_ITEM_LONG_CLICK_LISTENER = refClass(CanonicalNameConstants.ON_ITEM_LONG_CLICK_LISTENER);
        public final JClass ON_ITEM_CLICK_LISTENER = refClass(CanonicalNameConstants.ON_ITEM_CLICK_LISTENER);
        public final JClass ON_ITEM_SELECTED_LISTENER = refClass(CanonicalNameConstants.ON_ITEM_SELECTED_LISTENER);
        public final JClass WINDOW = refClass(CanonicalNameConstants.WINDOW);
        public final JClass MENU_ITEM = refClass(CanonicalNameConstants.MENU_ITEM);
        public final JClass MENU_INFLATER = refClass(CanonicalNameConstants.MENU_INFLATER);
        public final JClass MENU = refClass(CanonicalNameConstants.MENU);
        public final JClass ANIMATION_UTILS = refClass(CanonicalNameConstants.ANIMATION_UTILS);
        public final JClass RESOURCES = refClass(CanonicalNameConstants.RESOURCES);
        public final JClass CONFIGURATION = refClass(CanonicalNameConstants.CONFIGURATION);
        public final JClass MOTION_EVENT = refClass(CanonicalNameConstants.MOTION_EVENT);
        public final JClass HANDLER = refClass(CanonicalNameConstants.HANDLER);
        public final JClass KEY_STORE = refClass(CanonicalNameConstants.KEY_STORE);
        public final JClass VIEW_SERVER = refClass(CanonicalNameConstants.VIEW_SERVER);
        public final JClass PARCELABLE = refClass(CanonicalNameConstants.PARCELABLE);
        public final JClass LOOPER = refClass(CanonicalNameConstants.LOOPER);
        public final JClass POWER_MANAGER = refClass(CanonicalNameConstants.POWER_MANAGER);
        public final JClass WAKE_LOCK = refClass(CanonicalNameConstants.WAKE_LOCK);

    }

    private final Map<Element, GeneratedClassHolder> generatedClassHolders = new HashMap<Element, GeneratedClassHolder>();

    private final ProcessingEnvironment processingEnvironment;

    private final JCodeModel codeModel;

    private final Map<String, JClass> loadedClasses = new HashMap<String, JClass>();

    private final Classes classes;

    private final OriginatingElements originatingElements = new OriginatingElements();

    public ProcessHolder(ProcessingEnvironment processingEnvironment) {
        this.processingEnvironment = processingEnvironment;
        codeModel = new JCodeModel();
        classes = new Classes();
        refClass(CanonicalNameConstants.STRING);
        preloadJavaLangClasses();
    }

    private void preloadJavaLangClasses() {
        loadedClasses.put(String.class.getName(), refClass(String.class));
        loadedClasses.put(Object.class.getName(), refClass(Object.class));
    }

    public void put(Element element, GeneratedClassHolder generatedClassHolder) {

        JDefinedClass generatedClass = generatedClassHolder.getGeneratedClass();

        String qualifiedName = generatedClass.fullName();

        originatingElements.add(qualifiedName, element);

        generatedClassHolders.put(element, generatedClassHolder);
    }

    public GeneratedClassHolder getGeneratedClassHolder(Element element) {
        for (Element key : generatedClassHolders.keySet()) {
            if (key.asType().toString().equals(element.asType().toString())) {
                return generatedClassHolders.get(key);
            }
        }
        return null;
    }

    public JClass refClass(Class<?> clazz) {
        return codeModel.ref(clazz);
    }

    public JClass refClass(String fullyQualifiedClassName) {

        int arrayCounter = 0;
        while (fullyQualifiedClassName.endsWith("[]")) {
            arrayCounter++;
            fullyQualifiedClassName = fullyQualifiedClassName.substring(0, fullyQualifiedClassName.length() - 2);
        }

        JClass refClass = loadedClasses.get(fullyQualifiedClassName);

        if (refClass == null) {
            refClass = codeModel.directClass(fullyQualifiedClassName);
            loadedClasses.put(fullyQualifiedClassName, refClass);
        }

        for (int i = 0; i < arrayCounter; i++) {
            refClass = refClass.array();
        }

        return refClass;
    }

    public JDefinedClass definedClass(String fullyQualifiedClassName) {
        JDefinedClass refClass = (JDefinedClass) loadedClasses.get(fullyQualifiedClassName);
        if (refClass == null) {
            try {
                refClass = codeModel._class(fullyQualifiedClassName);
            } catch (JClassAlreadyExistsException e) {
                refClass = (JDefinedClass) refClass(fullyQualifiedClassName);
            }
            loadedClasses.put(fullyQualifiedClassName, refClass);
        }
        return refClass;
    }

    public ProcessingEnvironment processingEnvironment() {
        return processingEnvironment;
    }

    public JCodeModel codeModel() {
        return codeModel;
    }

    public Classes classes() {
        return classes;
    }

    public OriginatingElements getOriginatingElements() {
        return originatingElements;
    }


    public void generateApiClass(Element originatingElement, Class<?> apiClass) {
        originatingElements.add(apiClass.getCanonicalName(), originatingElement);

    }



}
