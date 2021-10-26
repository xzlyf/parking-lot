package com.xz.parking.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScopeDto {
    private List<String> scope;
}
