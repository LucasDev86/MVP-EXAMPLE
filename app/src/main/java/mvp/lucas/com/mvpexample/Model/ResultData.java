package mvp.lucas.com.mvpexample.Model;

import java.util.List;

/**
 * Created by rnj on 2016-10-14.
 */

public class ResultData {
    private String boxofficeType;
    private String showRange;
    private String yearWeekTime;
    private List<ListData> weeklyBoxOfficeList;

    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public String getYearWeekTime() {
        return yearWeekTime;
    }

    public void setYearWeekTime(String yearWeekTime) {
        this.yearWeekTime = yearWeekTime;
    }

    public List<ListData> getWeeklyBoxOfficeList() {
        return weeklyBoxOfficeList;
    }

    public void setWeeklyBoxOfficeList(List<ListData> weeklyBoxOfficeList) {
        this.weeklyBoxOfficeList = weeklyBoxOfficeList;
    }
}
