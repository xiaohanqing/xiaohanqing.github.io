package qunar.callcenter.api.enums;

/**
 * @Description
 * @Author feiju.chen <feiju.chen@qunar.com>
 * @Since 1.0
 * @Date 2020/4/30 16:13
 */
public enum AgentStatusEnum {
    LoggedIn("LoggedIn","签入"),
    WaitForNextCall("4","就绪"),
    OffHook("5","OffHook"),
    CallDialing("6","拨号"),
    CallRinging("7","振铃"),
    NotReadyForNextCall("8","不进线"),
    AfterCallWork("9","话后"),
    CallOnHold("13","保持中"),
    ASM_Engaged("16","ASM_Engaged"),
    ASM_Outbound("17","ASM_Outbound"),

    CallUnknown("18","CallUnknown"),
    CallConsult("19","咨询(第三方)"),
    CallInternal("20","CallInternal"),
    CallOutbound("21","外呼"),
    CallInbound("22","呼入"),
    LoggedOut("23","签出"),


    //NotReadyForNextCall("8","不进线"), 不进线的三种存在形式
    NotReadyForRest("0","小休"),
    NotReadyForEat("1","就餐"),
    NotReadyForTrain("2","培训"),
    NotReadyForOff("30","下班"),
    NotReadyForBusy("40","置忙"),

    OTHER("","未知"),

    ;

    private String code;
    private String desc;



    AgentStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AgentStatusEnum getAgentStatus(String statStatusCode,String reasonCode) {
        AgentStatusEnum agentStatusEnum = AgentStatusEnum.LoggedOut;
        for (AgentStatusEnum statusEnum : AgentStatusEnum.values()){
            if(statusEnum.getCode().equals(statStatusCode)){
                agentStatusEnum = statusEnum;
            }
        }

        if(agentStatusEnum == NotReadyForNextCall){
            if(NotReadyForEat.getCode().equals(reasonCode)){
                agentStatusEnum = NotReadyForEat;
            }else if(NotReadyForRest.getCode().equals(reasonCode)){
                agentStatusEnum = NotReadyForRest;
            }else if(NotReadyForTrain.getCode().equals(reasonCode)){
                agentStatusEnum = NotReadyForTrain;
            }else if(NotReadyForOff.getCode().equals(reasonCode)){
                agentStatusEnum = NotReadyForOff;
            }else if(NotReadyForBusy.getCode().equals(reasonCode)){
                agentStatusEnum = NotReadyForBusy;
            }
        }

        return agentStatusEnum;
    }

    public static AgentStatusEnum getAgentStatusByCode(String statusCode) {
        for (AgentStatusEnum statusEnum : AgentStatusEnum.values()){
            if(statusEnum.getCode().equals(statusCode)){
               return statusEnum;
            }
        }

        return OTHER;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
