package org.fusesource.camel.component.salesforce;

import org.apache.camel.RuntimeCamelException;
import org.eclipse.jetty.client.HttpClient;
import org.fusesource.camel.component.salesforce.api.dto.bulk.ContentType;
import org.fusesource.camel.component.salesforce.api.dto.bulk.OperationEnum;
import org.fusesource.camel.component.salesforce.internal.PayloadFormat;
import org.fusesource.camel.component.salesforce.internal.dto.NotifyForFieldsEnum;
import org.fusesource.camel.component.salesforce.internal.dto.NotifyForOperationsEnum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SalesforceEndpointConfig implements Cloneable {

    // default API version
    static final String DEFAULT_VERSION = "27.0";

    // general parameter
    public static final String API_VERSION = "apiVersion";

    // parameters for Rest API
    public static final String FORMAT = "format";
    public static final String SOBJECT_NAME = "sObjectName";
    public static final String SOBJECT_ID = "sObjectId";
    public static final String SOBJECT_FIELDS = "sObjectFields";
    public static final String SOBJECT_EXT_ID_NAME = "sObjectIdName";
    public static final String SOBJECT_EXT_ID_VALUE = "sObjectIdValue";
    public static final String SOBJECT_BLOB_FIELD_NAME = "sObjectBlobFieldName";
    public static final String SOBJECT_CLASS = "sObjectClass";
    public static final String SOBJECT_QUERY = "sObjectQuery";
    public static final String SOBJECT_SEARCH = "sObjectSearch";

    // parameters for Bulk API
    public static final String BULK_OPERATION = "bulkOperation";
    public static final String CONTENT_TYPE = "contentType";
    public static final String JOB_ID = "jobId";
    public static final String BATCH_ID = "batchId";
    public static final String RESULT_ID = "resultId";

    // parameters for Streaming API
    public static final String UPDATE_TOPIC = "updateTopic";

    // general properties
    private String apiVersion = DEFAULT_VERSION;

    // Rest API properties
    private PayloadFormat format = PayloadFormat.JSON;
    private String sObjectName;
    private String sObjectId;
    private String sObjectFields;
    private String sObjectIdName;
    private String sObjectIdValue;
    private String sObjectBlobFieldName;
    private String sObjectClass;
    private String sObjectQuery;
    private String sObjectSearch;

    // Bulk API properties
    private OperationEnum bulkOperation;
    private ContentType contentType;
    private String jobId;
    private String batchId;
    private String resultId;

    // Streaming API properties
    private boolean updateTopic;
    private NotifyForFieldsEnum notifyForFields;
    private NotifyForOperationsEnum notifyForOperations;

    // Jetty HttpClient, set using reference
    private HttpClient httpClient;

    public SalesforceEndpointConfig copy() {
        try {
            final SalesforceEndpointConfig copy = (SalesforceEndpointConfig) super.clone();
            // nothing to deep copy
            return copy;
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeCamelException(ex);
        }
    }

    public PayloadFormat getPayloadFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = PayloadFormat.valueOf(format.toUpperCase());
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getSObjectName() {
        return sObjectName;
    }

    public void setSObjectName(String sObjectName) {
        this.sObjectName = sObjectName;
    }

    public String getSObjectId() {
        return sObjectId;
    }

    public void setSObjectId(String sObjectId) {
        this.sObjectId = sObjectId;
    }

    public String getSObjectFields() {
        return sObjectFields;
    }

    public void setSObjectFields(String sObjectFields) {
        this.sObjectFields = sObjectFields;
    }

    public String getSObjectIdName() {
        return sObjectIdName;
    }

    public void setSObjectIdName(String sObjectIdName) {
        this.sObjectIdName = sObjectIdName;
    }

    public String getSObjectIdValue() {
        return sObjectIdValue;
    }

    public void setSObjectIdValue(String sObjectIdValue) {
        this.sObjectIdValue = sObjectIdValue;
    }

    public String getSObjectBlobFieldName() {
        return sObjectBlobFieldName;
    }

    public void setSObjectBlobFieldName(String sObjectBlobFieldName) {
        this.sObjectBlobFieldName = sObjectBlobFieldName;
    }

    public String getSObjectClass() {
        return sObjectClass;
    }

    public void setSObjectClass(String sObjectClass) {
        this.sObjectClass = sObjectClass;
    }

    public String getSObjectQuery() {
        return sObjectQuery;
    }

    public void setSObjectQuery(String sObjectQuery) {
        this.sObjectQuery = sObjectQuery;
    }

    public String getSObjectSearch() {
        return sObjectSearch;
    }

    public void setSObjectSearch(String sObjectSearch) {
        this.sObjectSearch = sObjectSearch;
    }

    public OperationEnum getBulkOperation() {
        return bulkOperation;
    }

    public void setBulkOperation(OperationEnum bulkOperation) {
        this.bulkOperation = bulkOperation;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public boolean isUpdateTopic() {
        return updateTopic;
    }

    public void setUpdateTopic(boolean updateTopic) {
        this.updateTopic = updateTopic;
    }

    public NotifyForFieldsEnum getNotifyForFields() {
        return notifyForFields;
    }

    public void setNotifyForFields(NotifyForFieldsEnum notifyForFields) {
        this.notifyForFields = notifyForFields;
    }

    public NotifyForOperationsEnum getNotifyForOperations() {
        return notifyForOperations;
    }

    public void setNotifyForOperations(NotifyForOperationsEnum notifyForOperations) {
        this.notifyForOperations = notifyForOperations;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public Map<String, String> toValueMap() {

        final Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put(FORMAT, format.toString().toLowerCase());
        valueMap.put(API_VERSION, apiVersion);

        valueMap.put(SOBJECT_NAME, sObjectName);
        valueMap.put(SOBJECT_ID, sObjectId);
        valueMap.put(SOBJECT_FIELDS, sObjectFields);
        valueMap.put(SOBJECT_EXT_ID_NAME, sObjectIdName);
        valueMap.put(SOBJECT_BLOB_FIELD_NAME, sObjectBlobFieldName);
        valueMap.put(SOBJECT_EXT_ID_VALUE, sObjectIdValue);
        valueMap.put(SOBJECT_CLASS, sObjectClass);
        valueMap.put(SOBJECT_QUERY, sObjectQuery);
        valueMap.put(SOBJECT_SEARCH, sObjectSearch);

        // add bulk API properties
        if (bulkOperation != null) {
            valueMap.put(BULK_OPERATION, bulkOperation.value());
        }
        if (contentType != null) {
            valueMap.put(CONTENT_TYPE, contentType.value());
        }
        valueMap.put(JOB_ID, jobId);
        valueMap.put(BATCH_ID, batchId);
        valueMap.put(RESULT_ID, resultId);

        valueMap.put(UPDATE_TOPIC, String.valueOf(updateTopic));

        return Collections.unmodifiableMap(valueMap);
    }
}