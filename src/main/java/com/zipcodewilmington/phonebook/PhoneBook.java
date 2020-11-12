package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.Map.Entry;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>();
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if(phonebook.containsKey(name)){
            return true;
        } else {
            return false;
        }
    }

    public Boolean hasEntry(String name, String number) {
        if(phonebook.containsKey(name) && phonebook.get(name).contains(number)) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String returnStr = "";
        for(Entry<String, List<String>> entry : phonebook.entrySet()) {
            for(List<String> numbers : phonebook.values()) {
                if(numbers.contains(phoneNumber)) {
                    returnStr = entry.getKey();
                }
            }
        }
        return returnStr;
    }

    public List<String> getAllContactNames() {
        List<String> returnList = new ArrayList<>();
        for(String key : phonebook.keySet()) {
            returnList.add(key);
        }
        return returnList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
