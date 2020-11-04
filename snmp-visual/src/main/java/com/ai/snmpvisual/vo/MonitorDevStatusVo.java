package com.ai.snmpvisual.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApiModel
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class MonitorDevStatusVo {

    @ApiModelProperty(notes = "设备数量")
    private int devNum;

    @ApiModelProperty(notes = "在线数量")
    private int onlineNum;

    @ApiModelProperty(notes = "离线数量")
    private int offlineNum;

    @ApiModelProperty(notes = "时间差")
    private String timeDiff;

    public MonitorDevStatusVo(int devNum, int onlineNum, int offlineNum, Date createTime) {
        this.devNum = devNum;
        this.onlineNum = onlineNum;
        this.offlineNum = offlineNum;
        this.timeDiff = timeDiffcal(createTime);
    }

    /*计算时间差*/
    private String timeDiffcal(Date createTime) {
        Date currentTime=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        String timeDiff="";
        if(createTime != null){
            String time_1 = format.format(createTime);
            String time_2 = format.format(currentTime);
            Date begin = null;
            Date end =null;
            try {
                 begin= format.parse(time_1);
                 end=format.parse(time_2);
                 diff = end.getTime()-begin.getTime();
                 day = diff / nd;// 计算差多少天
                 hour = diff % nd / nh + day * 24;// 计算差多少小时
                 min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
                 sec = diff % nd % nh % nm / ns;// 计算差多少秒
                 timeDiff=day+"天"+(hour - day * 24)+"小时"+(min - day * 24 * 60)+"分钟"+sec+"秒";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return timeDiff;
    }
}
