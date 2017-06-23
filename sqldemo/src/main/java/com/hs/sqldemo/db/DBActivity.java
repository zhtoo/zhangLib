package com.hs.sqldemo.db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.hs.sqldemo.R;


public class DBActivity extends Activity {

	  private ToDoDB myToDoDB;
	  private Cursor myCursor;
	  private ListView myListView;
	  private EditText myEditText;
	  private int _id;
	  protected final static int MENU_ADD = Menu.FIRST;
	  protected final static int MENU_EDIT = Menu.FIRST + 1;
	  protected final static int MENU_DELETE = Menu.FIRST + 2;

	  public boolean onOptionsItemSelected(MenuItem item)
	  {
	    super.onOptionsItemSelected(item);
	    switch (item.getItemId())
	    {
	      case MENU_ADD:
	        this.addTodo();
	        break;
	      case MENU_EDIT:
	        this.editTodo();
	        break;
	      case MENU_DELETE:
	        this.deleteTodo();
	        break;
	    }
	    return true;
	  }

	  public boolean onCreateOptionsMenu(Menu menu)
	  {
	    super.onCreateOptionsMenu(menu);
	    menu.add(Menu.NONE, MENU_ADD, 0, R.string.strAddButton);
	    menu.add(Menu.NONE, MENU_EDIT, 0, R.string.strEditButton);
	    menu.add(Menu.NONE, MENU_DELETE, 0, R.string.strDeleteButton);

	    return true;
	  }

	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    myListView = (ListView) this.findViewById(R.id.myListView);
	    myEditText = (EditText) this.findViewById(R.id.myEditText);

	    myToDoDB = new ToDoDB(this);
	    /* ȡ��DataBase������� */
	    myCursor = myToDoDB.select();

	    /* new SimpleCursorAdapter����myCursor���룬
	       ��ʾ���ݵ��ֶ�Ϊtodo_text */
	    SimpleCursorAdapter adapter = 
	    new SimpleCursorAdapter
	    (this, R.layout.list, myCursor, new String[]
	        { ToDoDB.FIELD_TEXT }, new int[]
	        { R.id.listTextView1 });
	    myListView.setAdapter(adapter);

	    /* ��myListView���OnItemClickListener */
	    myListView.setOnItemClickListener
	    (new AdapterView.OnItemClickListener()
	    {

	      public void onItemClick
	      (AdapterView<?> arg0, View arg1, int arg2, long arg3)
	      {
	        /* ��myCursor�Ƶ��������ֵ */
	        myCursor.moveToPosition(arg2);
	        /* ȡ���ֶ�_id��ֵ */
	        _id = myCursor.getInt(0);
	        /* ȡ���ֶ�todo_text��ֵ */
	        myEditText.setText(myCursor.getString(1));
	      }

	    });
	    myListView.setOnItemSelectedListener
	    (new AdapterView.OnItemSelectedListener()
	    {
	      public void onItemSelected
	      (AdapterView<?> arg0, View arg1, int arg2, long arg3)
	      {
	        /* getSelectedItem��ȡ�õ���SQLiteCursor */
	        SQLiteCursor sc = (SQLiteCursor) arg0.getSelectedItem();
	        _id = sc.getInt(0);
	        myEditText.setText(sc.getString(1));
	      }
	      
	      public void onNothingSelected(AdapterView<?> arg0)
	      {
	      }
	    });
	  }
	  
	  private void addTodo()
	  {
	    if (myEditText.getText().toString().equals(""))
	      return;
	    /* ������ݵ����ݿ� */
	    myToDoDB.insert(myEditText.getText().toString());
	    /* ���²�ѯ */
	    myCursor.requery();
	    /* ��������myListView */
	    myListView.invalidateViews();
	    myEditText.setText("");
	    _id = 0;
	  }

	  private void editTodo()
	  {
	    if (myEditText.getText().toString().equals(""))
	      return;
	    /* �޸����� */
	    myToDoDB.update(_id, myEditText.getText().toString());
	    myCursor.requery();
	    myListView.invalidateViews();
	    myEditText.setText("");
	    _id = 0;
	  }

	  private void deleteTodo()
	  {
	    if (_id == 0)
	      return;
	    /* ɾ������ */
	    myToDoDB.delete(_id);
	    myCursor.requery();
	    myListView.invalidateViews();
	    myEditText.setText("");
	    _id = 0;
}}