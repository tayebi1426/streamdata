package ir.streamdata.model.entity.schemadefinition;

import ir.streamdata.model.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class PrimitiveDataType extends BaseEntity<Integer> {


    private PrimitiveTypeCode code;
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    public PrimitiveTypeCode getCode() {
        return code;
    }

    public void setCode(PrimitiveTypeCode code) {
        this.code = code;
    }
    @Column(length = 40)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static enum PrimitiveTypeCode {
        BOOLEAN("boolean"),
        NUMBER("number"),
        STRING("STRING"),
        ARRAY("array");
        private final String val;

        PrimitiveTypeCode(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

}
