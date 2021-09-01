package com.kzen.cloud.advice;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: kzen
 * @Date: 2021/7/9 3:42 下午
 */
@ConfigurationProperties(value = "un-filter")
public class KzenDefaultProperties {

    private List<String> adviceFilterPackage = new ArrayList<>();
    private List<String> advicefilterClass = new ArrayList<>();

    public List<String> getAdviceFilterPackage() {
        return adviceFilterPackage;
    }

    public void setAdviceFilterPackage(List<String> adviceFilterPackage) {
        this.adviceFilterPackage = adviceFilterPackage;
    }

    public List<String> getAdvicefilterClass() {
        return advicefilterClass;
    }

    public void setAdvicefilterClass(List<String> advicefilterClass) {
        this.advicefilterClass = advicefilterClass;
    }
}
