/**
 * Copyright (c) 2015 The JobX Project
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package com.jobxhub.server.domain;

import com.google.common.base.Function;
import com.jobxhub.server.dto.Log;
import org.springframework.beans.BeanUtils;

import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by ChenHui on 2016/3/31.
 */
public class LogBean {

    private Long logId;

    private Long agentId;

    @Transient
    private String agentName;

    private Integer type;

    private String receiver;

    private String message;

    private String result;

    private Date sendTime;

    private Boolean isread;

    private Long userId;

    public LogBean() {}

    public LogBean(Log log){
        BeanUtils.copyProperties(log,this);
    }

    public static Function<? super Log, ? extends LogBean> transfer = new Function<Log, LogBean>() {
        @Override
        public LogBean apply(Log input) {
            return new LogBean(input);
        }
    };

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", agentId=" + agentId +
                ", type=" + type +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                ", sendTime=" + sendTime +
                ", isread=" + isread +
                '}';
    }
}
