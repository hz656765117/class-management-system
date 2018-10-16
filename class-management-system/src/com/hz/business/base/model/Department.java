package com.hz.business.base.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门表
 *
 * department
 *
 * @mbg.generated 2016-12-06 17:49:03
 */
public class Department implements Serializable {
    /**
     * 主键自增id
     *
     * department.id
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private String id;

    /**
     * 部门名称
     *
     * department.name
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private String name;

    /**
     * 父id
     *
     * department.parent_id
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Integer parentId;

    /**
     * 公司id
     *
     * department.company_id
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Integer companyId;

    /**
     * 企业号中对应的部门ID 理论上不为空，如果为空，则出现异常，需要同步
     *
     * department.qy_id
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Integer qyId;

    /**
     * 企业号中对应的父部门ID
     *
     * department.qy_parentId
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Integer qyParentid;

    /**
     * 排序字段,越小越前
     *
     * department.paixu
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Integer paixu;

    /**
     * 部门层级关系，冗余字段，如1-2-4 表示 1节点下2节点下4节点
     *
     * department.full_ids
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private String fullIds;

    /**
     * 部门冗余名称
     *
     * department.full_names
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private String fullNames;

    /**
     * 是否为叶子节点
     *
     * department.is_leaf
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Boolean isLeaf;

    /**
     * 状态  目前用于同步时使用   1 正在同步中（同步完成后 仍然为1的 需要删除掉数据）
     *
     * department.status
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Integer status;

    /**
     * 权限
     *
     * department.permission
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private String permission;

    /**
     * 创建人
     *
     * department.creator
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private String creator;

    /**
     * 创建时间
     *
     * department.create_time
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * department.update_time
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Date updateTime;

    /**
     *
     * department.delete_flag
     *
     * @mbg.generated 2016-12-06 17:49:03
     */
    private Boolean deleteFlag;

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    private static final long serialVersionUID = 1L;
    
    private boolean permitCheck;
    private Long personCount ;
 

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public String getName() {
        return name;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Integer getQyId() {
        return qyId;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setQyId(Integer qyId) {
        this.qyId = qyId;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Integer getQyParentid() {
        return qyParentid;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setQyParentid(Integer qyParentid) {
        this.qyParentid = qyParentid;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Integer getPaixu() {
        return paixu;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public String getFullIds() {
        return fullIds;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setFullIds(String fullIds) {
        this.fullIds = fullIds == null ? null : fullIds.trim();
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public String getFullNames() {
        return fullNames;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setFullNames(String fullNames) {
        this.fullNames = fullNames == null ? null : fullNames.trim();
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Boolean getIsLeaf() {
        return isLeaf;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @mbg.generated 2016-12-06 17:49:03
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }


	public boolean isPermitCheck() {
		return permitCheck;
	}

	public void setPermitCheck(boolean permitCheck) {
		this.permitCheck = permitCheck;
	}
    

	public Long getPersonCount() {
		return personCount;
	}

	public void setPersonCount(Long personCount) {
		this.personCount = personCount;
	}
    
    

}