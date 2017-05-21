package cn.tarena.ht.pojo;

/**
 * Created by Administrator on 2017/5/26.
 */
public class Role extends BaseEntity {

    private String roleId;
    private String name;
    private String remarks;
    private Integer orderNo;
    private boolean checked;

    /*为数据回写设置属性*/
    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /*为ztree树专门添加的get,set方法*/
    public String getId() {
        return roleId;
    }

    public void setId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

//    public Integer getOrderno() {
//        return orderno;
//    }
//
//    public void setOrderno(Integer orderno) {
//        this.orderno = orderno;
//    }
}
