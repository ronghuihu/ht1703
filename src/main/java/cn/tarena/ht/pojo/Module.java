package cn.tarena.ht.pojo;

/**
 * Created by Administrator on 2017/5/27.
 */
public class Module extends BaseEntity{

        private String moduleId;
        private Module parentModule;
        private String name;
        private Integer state;
        private Integer ctype;
        private Integer orderNo;
        private boolean checked;

        public boolean getChecked() {
                return checked;
        }

        public void setChecked(boolean checked) {
                this.checked = checked;
        }

        public String getId() {
                return moduleId;
        }

        public String getModuleId() {
                return moduleId;
        }

        public void setModuleId(String moduleId) {
                this.moduleId = moduleId;
        }

        public String getpId() {
                if (parentModule != null){
                        return parentModule.getModuleId();
                }
                return "";
        }

        public void setId(String moduleId) {
                this.moduleId = moduleId;
        }

        public Module getParentModule() {
                return parentModule;
        }

        public void setParentModule(Module parentModule) {
                this.parentModule = parentModule;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getState() {
                return state;
        }

        public void setState(Integer state) {
                this.state = state;
        }

        public Integer getCtype() {
                return ctype;
        }

        public void setCtype(Integer ctype) {
                this.ctype = ctype;
        }

        public Integer getOrderNo() {
                return orderNo;
        }

        public void setOrderNo(Integer orderNo) {
                this.orderNo = orderNo;
        }
}
