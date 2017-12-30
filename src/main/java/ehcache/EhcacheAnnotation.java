package ehcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import dao.TmmsUserMapper;
import entity.TmmsUser;


/**
 * 
 * @author wujiyuan
 * Ehcache利用Spring注解示例
 *
 */
@Service
public class EhcacheAnnotation {
	// @Cacheable可以设置多个缓存，形式如：@Cacheable({"books", "isbns"})
	@Autowired
	TmmsUserMapper tmmsUserMapper;
    @Cacheable(value = "userCache")
   public TmmsUser findUser(int id) {
    	TmmsUser tt=tmmsUserMapper.selectByPrimaryKey(id);
    	return tt;
   }

    /*@Cacheable(value = "users", condition = "#user.getId() <= 2")
    public User findUserInLimit(User user) {
        return findUserInDB(user.getId());
    }

    @CachePut(value = "users", key = "#user.getId()")
    public void updateUser(User user) {
        updateUserInDB(user);
    }

    @CacheEvict(value = "users")
    public void removeUser(User user) {
        removeUserInDB(user.getId());
    }

    @CacheEvict(value = "users", allEntries = true)
    public void clear() {
        removeAllInDB();
    }*/
    
    //public User findUserInDB(int userId){
    	//UserService userService=new UserServiceImpl();
    	//return userService.getUserById(userId);
   // }
    public static void main(String args[]){
    	EhcacheAnnotation ea=new EhcacheAnnotation();
    	System.out.println(ea.findUser(1));
    }
}
