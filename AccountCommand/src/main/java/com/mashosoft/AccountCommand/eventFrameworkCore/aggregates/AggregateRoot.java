package com.mashosoft.AccountCommand.eventFrameworkCore.aggregates;

import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AggregateRoot {
    protected String id;
    private Integer version = -1;

    private final List<BaseEvent> changes = new ArrayList<>();

    public String getId(){
        return this.id;
    }

    public Integer getVersion(){
        return this.version;
    }

    public void setVersion(Integer version){
        this.version = version;
    }

    public List<BaseEvent> getUncommittedChanges(){
        return this.changes;
    }

    public void markChangesAsCommitted(){
        this.changes.clear();
    }

    protected void applyChange(BaseEvent event, Boolean isNewEvent){
        try{
            Method method = getClass().getDeclaredMethod( "apply", event.getClass() );
            method.setAccessible( true );
            method.invoke( this, event );
        } catch (NoSuchMethodException e){
            log.error( "The apply method was not found in the aggregate for {0}", event.getClass().getName() );
        } catch (Exception e){
            log.error( "Error applying event to aggregate" );
        } finally {
            if(isNewEvent){
                changes.add( event );
            }
        }
    }

    public void raiseEvent(BaseEvent event){
        applyChange( event,true );
    }

    public void replayEvents(Iterable<BaseEvent> events){
        events.forEach( event -> applyChange( event,false ) );
    }
}