
/**
 * Copyright (C) 2013-2016 banditcat
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
package com.banditcat.android.transformer.parser;


/**
 * 文件名称：{@link AbstractParser}
 * <br/>
 * 功能描述：This is the base class to implement a custom parser to your transformations.
 * <br/>
 * 创建作者：banditcat
 * <br/>
 * 创建时间：16/8/25 13:40
 * <br/>
 * 修改作者：banditcat
 * <br/>
 * 修改时间：16/8/25 13:40
 * <br/>
 * 修改备注：
 */
public abstract class AbstractParser<T1, T2> {

    public T2 parse(T1 value) {
        return onParse(value);
    }

    /**
     * Override this method to implement the logic of your parser.
     *
     * @param value The value that will to be parse.
     * @return The parser result value.
     */
    protected abstract T2 onParse(T1 value);
}
