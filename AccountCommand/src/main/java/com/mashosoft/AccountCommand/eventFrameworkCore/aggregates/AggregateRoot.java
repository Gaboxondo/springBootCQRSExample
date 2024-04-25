package com.mashosoft.AccountCommand.eventFrameworkCore.aggregates;

import com.mashosoft.AccountCommand.eventFrameworkCore.events.BaseEvent;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Slf4j
public abstract class AggregateRoot {
    protected String id;
    private Integer version = -1;

    private final List<BaseEvent> newEventsChanges = new ArrayList<>();

    public String getId(){
        return this.id;
    }

    public Integer getVersion(){
        return this.version;
    }

    public void setVersion(Integer version){
        this.version = version;
    }

    public List<BaseEvent> getUncommitedEventChanges(){
        return this.newEventsChanges;
    }

    public void clearNewEventChanges(){
        this.newEventsChanges.clear();
    }

    protected void applyEventChange(BaseEvent event, Boolean isNewEvent){
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
                newEventsChanges.add( event );
            }
        }
    }

    public void applyNewEvent(BaseEvent event){
        applyEventChange( event,true );
    }

    public void reconstructFromEvents(Iterable<BaseEvent> events){
        events.forEach( event -> applyEventChange( event,false ) );;
        Optional<Integer> latestVersion = StreamSupport.stream( events.spliterator(), false)
            .map( BaseEvent::getVersion ).max( Comparator.naturalOrder() );
        this.version = latestVersion.get();
    }
}
