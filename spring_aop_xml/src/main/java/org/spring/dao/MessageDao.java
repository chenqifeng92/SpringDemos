package org.spring.dao;

import org.spring.model.LogInfo;

public interface MessageDao {
    @LogInfo("通过LogInfo添加了留言信息")
    public void add();
    @LogInfo("通过LogInfo删除了留言信息")
    public void delete();
    public void load();
}