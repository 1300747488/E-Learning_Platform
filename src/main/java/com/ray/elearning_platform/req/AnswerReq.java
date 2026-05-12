package com.ray.elearning_platform.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerReq {

    private Integer questionId; // 题目ID

    private String selectedOption; // 学生选择的答案：A / B / C / D
}