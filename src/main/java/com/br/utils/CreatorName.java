package com.br.utils;

import com.br.types.Tipos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreatorName {
    private final Character PREFIX_YEAR = 'V';
    private final String EXTENSION = '.sql';
    public CreatorName(){}

    public  String createNameFile(Tipos tipos ,String sufixo){
        String day = formatterInteger(LocalDate.now().getDayOfMonth())+".";
        String month = formatterInteger(LocalDate.now().getMonthValue())+".";
        String year =String.valueOf(LocalDate.now().getYear())+".";
        String hora = formatterInteger(LocalDateTime.now().getHour())+".";
        String minuto = formatterInteger(LocalDateTime.now().getMinute());
        return PREFIX_YEAR+year+month+day+hora+minuto+"__"+tipos.getDesc()+"_"+sufixo+EXTENSION;
    }

    public String formatterInteger(Integer integer){
        return integer <10 ? "0"+integer : integer+"";
    }
}
