/**
 * Copyright 2016 benjobs
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


package org.opencron.server.service;

import org.opencron.server.dao.QueryDao;
import org.opencron.server.domain.Group;
import org.opencron.server.tag.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class GroupService {

    @Autowired
    private QueryDao queryDao;

    public PageBean<Group> getGroupPage(PageBean pageBean) {
        return queryDao.getPageBySql(pageBean,Group.class,"SELECT G.*,U.userName FROM T_GROUP AS G INNER JOIN T_USER AS U ON G.userId=u.userId");
    }

    public List<Group> getAll() {
        return queryDao.getAll(Group.class);
    }
}
