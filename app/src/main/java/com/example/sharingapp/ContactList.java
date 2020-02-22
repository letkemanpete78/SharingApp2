package com.example.sharingapp;


import android.content.Context;

import java.util.List;
import java.util.Objects;

public class ContactList {
    private List<Contact> contacts;
    private String FILENAME;
    private List<String> userName;

    public ContactList(List<Contact> contacts, String FILENAME, List<String> userName) {
        this.contacts = contacts;
        this.FILENAME = FILENAME;
        this.userName = userName;
    }

    public ContactList() {
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<String> getAllUsernames() {
        return userName;
    }

    public void addContract(Contact contact) {
        // todo: add 'add' logic here
    }

    public void deleteContract(Contact contact) {
        // todo: add delete logic here
    }

    public int getSize() {
        return 0;
    }

    public Contact getContact(int index) {
        // todo: add delete logic here
        return new Contact();
    }

    public int getIndex(Contact contact) {
        // todo: add index logic here
        return 0;
    }

    public boolean hasContact(Contact contact) {
        return true;
    }

    public Contact getContactByUsername(String username) {
        // todo: add search logic here
        return new Contact();
    }

    public void loadContacts(Context context) {
        // todo: load logic here
    }

    public void saveContacts(Context context) {
        // todo: add save logic here
    }

    public boolean isUsernameAvailable(String username) {
        // todo: add availble logic here
        return true;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public List<String> getUserName() {
        return userName;
    }

    public void setUserName(List<String> userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactList that = (ContactList) o;
        return Objects.equals(contacts, that.contacts) &&
                Objects.equals(FILENAME, that.FILENAME) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contacts, FILENAME, userName);
    }

    @Override
    public String toString() {
        return "ContactList{" +
                "contacts=" + contacts +
                ", FILENAME='" + FILENAME + '\'' +
                ", userName=" + userName +
                '}';
    }

    public void deleteContact(Contact contact) {
        // todo: add delete logic here
    }

    public void addContact(Contact updated_contact) {
        // todo: add 'add' logic here
    }
}
