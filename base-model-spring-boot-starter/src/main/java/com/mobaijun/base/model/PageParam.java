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
package com.mobaijun.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.3.2
 * ClassName: PageParam
 * 类描述： 分页
 *
 * @author MoBaiJun 2022/5/7 15:54
 */
@Getter
@Setter
@ToString
@ApiModel(description = "分页查询参数")
@Schema(title = "分页查询参数")
public class PageParam {

    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码,从 1 开始", allowableValues = "1", example = "1")
    @Schema(title = "当前页码", description = "从 1 开始", defaultValue = "1", example = "1")
    @Min(value = 1, message = "当前页不能小于 1")
    private long current = 1;

    /**
     * 每页显示条数不能小于1
     */
    @ApiModelProperty(value = "每页显示条数,最大值为系统设置，默认 100", example = "10")
    @Schema(title = "每页显示条数", description = "最大值为系统设置，默认 100", defaultValue = "10")
    @Min(value = 1, message = "每页显示条数不能小于1")
    private long size = 10;

    /**
     * 排序规则
     */
    @ApiModelProperty(value = "排序规则")
    @Schema(title = "排序规则")
    @Valid
    private List<Sort> sorts = new ArrayList<>();

    @Getter
    @Setter
    @ApiModel(description = "排序元素载体")
    @Schema(title = "排序元素载体")
    public static class Sort {

        /**
         * 排序字段格式非法
         */
        @ApiModelProperty(value = "排序字段", example = "id")
        @Schema(title = "排序字段", example = "id")
        @Pattern(regexp = PageParamRequest.SORT_FILED_REGEX, message = "排序字段格式非法")
        private String field;

        /**
         * 是否正序排序
         */
        @ApiModelProperty(value = "是否正序排序", example = "false")
        @Schema(title = "是否正序排序", example = "false")
        private boolean asc;
    }
}