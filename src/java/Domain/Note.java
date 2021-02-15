/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author 842458
 */
public class Note {
    String title;
    String content;
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setNote(String content){
        this.content = content;
    }
    public String getNote(){
        return content;
    }
}
