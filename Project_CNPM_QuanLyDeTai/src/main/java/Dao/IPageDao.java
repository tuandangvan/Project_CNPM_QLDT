package Dao;

import Models.PageModel;

public interface IPageDao {

	PageModel PageStudent(String key);
	PageModel PageTeacher(String key);
	PageModel PageTopic(String key);
}
