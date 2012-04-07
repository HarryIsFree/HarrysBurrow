/**
 * Created by IntelliJ IDEA.
 * User: lvxiang
 * Date: 12-3-23
 * Time: 上午12:50
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;

public class Event {

    private long id;
    private String title;
    private Date date;

    /**
     * This no-argument constructor is required for all persistent classes
     */
    public Event(){

    }

    public long getId(){

        return this.id;

    }

    public void setId(long ID){

        this.id = ID;

    }

    public String getTitle(){

        return  this.title;
    }

    public void setTitle(String title1){
        this.title = title1;
    }

    public Date getDate(){

        return this.date;
    }

    public void setDate(Date date1){
        this.date = date1;
    }
}

