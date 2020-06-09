package com.dto.DTO.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by jt on 9/28/17.
 */
abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}