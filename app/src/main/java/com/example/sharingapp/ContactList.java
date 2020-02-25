package com.example.sharingapp;


import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
    if (userName == null) {
      List<String> list = new ArrayList<>();
      list.add("");
      return list;
    }
    return userName;
  }

  public void addContract(Contact contact) {
    if (contact != null) {
      this.contacts.add(contact);
    }
  }

  public void deleteContract(Contact contact) {
    if (contact != null) {
      this.contacts.remove(contact);
    }
  }

  public int getSize() {
    return contacts.size();
  }

  public Contact getContact(int index) {
    return contacts.get(index);
  }

  public int getIndex(Contact contact) {
    // todo: add index logic here
    if (contact != null) {
      return contacts.indexOf(contact);
    }
    return 0;
  }

  public boolean hasContact(Contact contact) {
    return contacts.contains(contact);
  }

  public Contact getContactByUsername(final String username) {
    if (username != null) {
      for (Contact c : contacts) {
        if (username.equalsIgnoreCase(c.getUsername())) {
          return c;
        }
      }
    }
    return new Contact();
  }

  public void loadContacts(Context context) {
    try {
      FileInputStream fis = context.openFileInput(FILENAME);
      InputStreamReader isr = new InputStreamReader(fis);
      Gson gson = new Gson();
      Type listType = new TypeToken<ArrayList<Item>>() {
      }.getType();
      contacts = gson.fromJson(isr, listType); // temporary
      fis.close();
    } catch (FileNotFoundException e) {
      contacts = new ArrayList<>();
    } catch (IOException e) {
      contacts = new ArrayList<>();
    }
  }

  public void saveContacts(Context context) {
    try {
      FileOutputStream fos = context.openFileOutput(FILENAME, 0);
      OutputStreamWriter osw = new OutputStreamWriter(fos);
      Gson gson = new Gson();
      gson.toJson(contacts, osw);
      osw.flush();
      fos.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isUsernameAvailable(String username) {
    if (username != null) {
      boolean foundUser = false;
      for (Contact c : contacts) {
        if (username.equalsIgnoreCase(c.getUsername())) {
          foundUser = true;
          break;
        }
      }
      return !foundUser;
    }
    return false;
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
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
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

  public void deleteContact(Contact contact, Context context) {
    if (contact == null || context == null) {
      return;
    }
    if (contacts.contains(contact)) {
      contacts.remove(contact);

      try {
        FileOutputStream fos = context.openFileOutput(FILENAME, 0);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        Gson gson = new Gson();
        gson.toJson(contacts, osw);
        osw.flush();
        fos.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }

  public void addContact(Contact updated_contact) {
    if (updated_contact == null){
      return;
    }
    if (!contacts.contains(updated_contact)){
      contacts.add(updated_contact);
    }
  }
}
