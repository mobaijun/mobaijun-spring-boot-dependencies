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
package com.mobaijun.captcha.exception;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: TextCaptchaException
 * class description： 文字验证码异常
 *
 * @author MoBaiJun 2022/10/27 10:35
 */
public class TextCaptchaException extends RuntimeException {
    public TextCaptchaException() {
    }

    public TextCaptchaException(String message) {
        super(message);
    }

    public TextCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextCaptchaException(Throwable cause) {
        super(cause);
    }

    public TextCaptchaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}