package com.amistrong.express.beans.response;

import java.io.Serializable;

/**
 * Created by logan on 2018/5/17.
 */
public class SynthesisExchange implements Serializable {

    // 序列化接口属性
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String rfid;

    private String toolID;

    private String toolCode;

    private String SynthesisParametersID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getToolID() {
        return toolID;
    }

    public void setToolID(String toolID) {
        this.toolID = toolID;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getSynthesisParametersID() {
        return SynthesisParametersID;
    }

    public void setSynthesisParametersID(String synthesisParametersID) {
        SynthesisParametersID = synthesisParametersID;
    }
}
