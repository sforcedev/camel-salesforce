/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.camel.component.salesforce.internal;

public enum ApiName {

    // rest APIs
    GET_VERSIONS("getVersions"),
    GET_RESOURCES("getResources"),
    GET_GLOBAL_OBJECTS("getGlobalObjects"),
    GET_BASIC_INFO("getBasicInfo"),
    GET_DESCRIPTION("getDescription"),
    GET_SOBJECT("getSObject"),
    CREATE_SOBJECT("createSObject"),
    UPDATE_SOBJECT("updateSObject"),
    DELETE_SOBJECT("deleteSObject"),
    GET_SOBJECT_WITH_ID("getSObjectWithId"),
    UPSERT_SOBJECT("upsertSObject"),
    DELETE_SOBJECT_WITH_ID("deleteSObjectWithId"),
    QUERY("query"),
    QUERY_MORE("queryMore"),
    SEARCH("search"),

    // bulk APIs
    CREATE_JOB("createJob"),
    GET_JOB("getJob"),
    CLOSE_JOB("closeJob"),
    ABORT_JOB("abortJob"),
    CREATE_BATCH("createBatch"),
    GET_BATCH("getBatch"),
    GET_ALL_BATCHES("getAllBatches"),
    GET_REQUEST("getRequest"),
    GET_RESULTS("getResults"),
    CREATE_BATCH_QUERY("createBatchQuery"),
    QUERY_RESULT_LIST("queryResultList"),
    QUERY_RESULT("queryResult");

    private final String value;

    private ApiName(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static ApiName fromValue(String value) {
        for (ApiName apiName : ApiName.values()) {
            if (apiName.value.equals(value)) {
                return apiName;
            }
        }
        throw new IllegalArgumentException(value);
    }
}