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
package com.mobaijun.base.json;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ConverterToJson
 * class description：对象转 json 字符串
 *
 * @author MoBaiJun 2022/10/17 8:47
 */
public class ConverterToJson {

    /**
     * ApiModelProperty 对象转 json 格式数据
     *
     * @param isPage 是否分页
     * @param c      对象
     * @param <T>    类型
     */
    public static <T> void apiModelPropertyCoverToJson(boolean isPage, Class<T> c) {
        // 获取所有的字段
        Field[] fields = c.getDeclaredFields();
        StringBuilder sb = new StringBuilder("{");
        String pageFieldStr = "{\"startRow\":0,\"parameter\":{\"current\":\"当前页码,从 1 开始\",\"size\":\"每页显示条数,最大值为系统设置，默认 100\",\"sorts\":\"排序规则\"},\"size\":20,\"current\":1}";
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(fields).forEach(temp -> {
            // 判断字段注解是否存在
            boolean annotationPresent2 = temp.isAnnotationPresent(ApiModelProperty.class);
            if (annotationPresent2) {
                ApiModelProperty name = temp.getAnnotation(ApiModelProperty.class);
                // 获取注解值
                stringConcAten(temp, fields, i, sb, name.value());
            }
            i.getAndIncrement();
        });
        sb.append("}");
        System.out.println(isPage ? pageFieldStr.replace("parameterReplace", sb.toString()) : sb.toString());
    }

    /**
     * Schema注解对象转 json 格式数据
     *
     * @param isPage 是否分页
     * @param c      对象
     * @param <T>    类型
     */
    public static <T> void schemaCoverToJson(boolean isPage, Class<T> c) {
        // 获取所有的字段
        Field[] fields = c.getDeclaredFields();
        StringBuilder sb = new StringBuilder("{");
        String pageFieldStr = "{\"startRow\":0,\"parameter\":{\"current\":\"当前页码,从 1 开始\",\"size\":\"每页显示条数,最大值为系统设置，默认 100\",\"sorts\":\"排序规则\"},\"size\":20,\"current\":1}";
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(fields).forEach(temp -> {
            // 判断字段注解是否存在
            boolean annotationPresent2 = temp.isAnnotationPresent(Schema.class);
            if (annotationPresent2) {
                Schema name = temp.getAnnotation(Schema.class);
                // 获取注解值
                stringConcAten(temp, fields, i, sb, name.title());
            }
            i.getAndIncrement();
        });
        sb.append("}");
        System.out.println(isPage ? pageFieldStr.replace("parameterReplace", sb.toString()) : sb.toString());
    }

    /**
     * 字符串拼接
     *
     * @param temp   临时变量
     * @param fields 字段
     * @param i      i
     * @param sb     字符串
     * @param value  注解值
     */
    private static void stringConcAten(Field temp, Field[] fields, AtomicInteger i, StringBuilder sb, String value) {
        if (i.get() == fields.length - 1) {
            sb.append("\"").append(temp.getName()).append("\":").append("\"").append(value).append("\"");
        } else {
            sb.append("\"").append(temp.getName()).append("\":").append("\"").append(value).append("\",");
        }
    }
}