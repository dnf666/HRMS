package com.facishare.crm.stock.predefine.manager;

import com.facishare.crm.rest.dto.ReturnOrderModel;
import com.facishare.crm.rest.dto.SalesOrderModel;
import com.facishare.crm.stock.exception.StockBusinessException;
import com.facishare.crm.stock.exception.StockErrorCode;
import com.facishare.paas.appframework.core.model.ServiceFacade;
import com.facishare.paas.appframework.core.model.User;
import com.facishare.paas.metadata.api.IObjectData;
import com.facishare.paas.metadata.api.QueryResult;
import com.facishare.paas.metadata.api.search.IFilter;
import com.facishare.paas.metadata.dispatcher.ObjectDataProxy;
import com.facishare.paas.metadata.impl.search.OrderBy;
import com.facishare.paas.metadata.impl.search.SearchTemplateQuery;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

@Slf4j(topic = "stockAccess")
public class CommonManager {

    @Resource
    private ServiceFacade serviceFacade;

    @Resource
    private ObjectDataProxy objectDataProxy;

    public QueryResult<IObjectData> searchQuery(User user, String objectApiName, List<IFilter> filters, List<OrderBy> orders, int offset, int limit, int permissionType) {
        SearchTemplateQuery searchTemplateQuery = new SearchTemplateQuery();
        searchTemplateQuery.setOffset(offset);
        searchTemplateQuery.setFilters(filters);
        searchTemplateQuery.setLimit(limit);
        searchTemplateQuery.setOrders(orders);
        searchTemplateQuery.setWheres(Lists.newArrayList());
        searchTemplateQuery.setPermissionType(permissionType); //0不走权限  1走权限
        return serviceFacade.findBySearchQuery(user, objectApiName, searchTemplateQuery);
    }

    public SalesOrderModel.QueryOrderProductArg buildGetProductsByIdArg(String salesOrderId) {
        SalesOrderModel.QueryOrderProductArg arg = new SalesOrderModel.QueryOrderProductArg();
        arg.setOffset(0);
        // 需一次把它全部查询出来，所以设置个很大的值
        arg.setLimit(10000);
        SalesOrderModel.QueryOrderProductArg.Condition condition = new SalesOrderModel.QueryOrderProductArg.Condition();
        condition.setConditionType("0");
        SalesOrderModel.SalesOrderVo conditions = new SalesOrderModel.SalesOrderVo();
        conditions.setCustomerTradeId(salesOrderId);
        condition.setConditions(conditions);
        arg.setConditions(Lists.newArrayList(condition));
        return arg;
    }

    public ReturnOrderModel.QueryReturnOrderProductArg buildGetReturnProductsByIdArg(String returnOrderId) {
        ReturnOrderModel.QueryReturnOrderProductArg arg = new ReturnOrderModel.QueryReturnOrderProductArg();
        arg.setOffset(0);
        // 需一次把它全部查询出来，所以设置个很大的值
        arg.setLimit(10000);
        ReturnOrderModel.QueryReturnOrderProductArg.Condition condition = new ReturnOrderModel.QueryReturnOrderProductArg.Condition();
        condition.setConditionType("0");
        ReturnOrderModel.ReturnOrderVo conditions = new ReturnOrderModel.ReturnOrderVo();
        conditions.setReturnOrderId(returnOrderId);
        condition.setConditions(conditions);
        arg.setConditions(Lists.newArrayList(condition));
        return arg;
    }

    public List<IObjectData> findByIds(User user, List<String> objectIds, String objectApiName) {
        List<IObjectData> objectDataList = serviceFacade.findObjectDataByIdsIncludeDeleted(user, objectIds, objectApiName);
        if (objectDataList == null) {
            return Lists.newArrayList();
        }
        return objectDataList;
    }

    public IObjectData findById(User user, String id, String objectApiName) {
        IObjectData objectData = serviceFacade.findObjectData(user, id, objectApiName);
        if (objectData == null) {
            throw new StockBusinessException(StockErrorCode.BUSINESS_ERROR, "查询自定义对象数据失败");
        }
        return objectData;
    }
}
