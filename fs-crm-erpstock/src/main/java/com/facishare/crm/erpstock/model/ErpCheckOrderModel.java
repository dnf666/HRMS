package com.facishare.crm.erpstock.model;

import com.facishare.paas.metadata.api.IObjectData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author linchf
 * @date 2018/5/10
 */
public class ErpCheckOrderModel {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CheckProduct {
        String productId;
        BigDecimal productNum;
        String productName;
    }

    @Data
    public static class Arg {
        String warehouseId;
        List<CheckProduct> checkProducts;
    }

    @Data
    public static class Result {
        Boolean isSuccess;
        String message;
    }

    @Data
    public static class CheckProductStock {
        List<String> productIds;
        List<IObjectData> checkProductStock;
        Map<String, BigDecimal> checkProductNum;
    }
}
