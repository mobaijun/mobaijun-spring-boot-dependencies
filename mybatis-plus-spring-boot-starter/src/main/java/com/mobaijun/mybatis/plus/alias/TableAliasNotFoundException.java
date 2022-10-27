/*
 * Copyright (C) 2022 www.mobaijun.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobaijun.mybatis.plus.alias;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: TableAliasNotFoundException
 * 类描述：TableAlias 注解没有找到时抛出的异常
 *
 * @author MoBaiJun 2022/5/7 16:17
 */
public class TableAliasNotFoundException extends RuntimeException {

    public TableAliasNotFoundException() {
    }

    public TableAliasNotFoundException(String message) {
        super(message);
    }

    public TableAliasNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableAliasNotFoundException(Throwable cause) {
        super(cause);
    }
}