package com.join.joinblog.controller.blog;

import com.join.joinblog.controller.user.UserController;
import com.join.joinblog.controller.util.UtilController;
import com.join.joinblog.entity.blog.Blog;

import com.join.joinblog.entity.user.User;
import com.join.joinblog.service.blog.impl.BlogServiceImpl;
import com.join.joinblog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:ljx
 * @Date:2019/9/6
 * @Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;

    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    @Autowired
    private UtilController utilController;
    /**
     * 测试用
     * @return
     */
    @RequestMapping(value = "/hello")
    public String say(){
        return "hello test";
    }

    /**
     * 通过id查博客
     * @param id
     * @return
     */
    @RequestMapping("/queryById/{id}")
    public List queryById(@PathVariable int id)throws Exception{
        List list=blogService.queryById(id);
        Blog blog=(Blog)list.get(0);
        User user=userController.queryHead(blog.getBloggerName());
        list.add(user);
        return list;
    }


    /**
     * 通过博主id查博客
     * @param bloggerId
     * @return
     */
    @RequestMapping("/queryByBloggerId/{bloggerId}")
    public List queryByBloggerId(@PathVariable int bloggerId){return blogService.queryByBloggerId(bloggerId);}

    /**
     * 查询所有博客
     * @return
     */
    @RequestMapping("/queryAll")
    public List queryAll(){
        return blogService.queryAll();
    }

    @RequestMapping("/queryByTags/{tag}")
    public List queryByTags(@PathVariable String tag){return blogService.queryByTag(tag);}

    @RequestMapping("/addTagById/{id}/{tag}")
    public void addTagById(@PathVariable int id, @PathVariable String tag){
        Blog blog=(Blog)blogService.queryById(id).get(0);
        String tags;
        if(blog.getTags().equals("")){
            tags=","+tag;
        }else {
            tags=blog.getTags()+","+tag;
        }

        blogService.updateTagsById(tags,id);
    }

    @RequestMapping("queryByTag/{tag}")
    public List queryByTag(@PathVariable String tag){
        return blogService.queryByTag(tag);
    }

    @RequestMapping("deleteTagById/{id}/{tag}")
    public void deleteTag(@PathVariable String tag, @PathVariable int id){
        Blog blog=(Blog)blogService.queryById(id).get(0);
        String tags=blog.getTags();
        String[] tagList=tags.split(",");
        System.out.println(tagList);
        for(String tag1:tagList){
            if(tag1.equals(tag)){
                tag1="";
                break;
            }
        }
        tags="";
        for(String tag1:tagList){
            tags+=","+tag1;
        }
        blogService.updateTagsById(tags,id);
    }

    /**
     * 返回所有博客id
     * @return
     */
    @RequestMapping("getBlogIds")
    public int[] getBlogIds(){
        return blogService.getBlogIds();
    }

    /**
     * 删除博客
     * @param da
     */
    @RequestMapping("/delete")
    public int deleteById(@RequestBody int da){
        System.out.println(da);
        if(blogService.deleteById(da))
            return 1;
        return 0;
    }
    @RequestMapping("/getAllInTwoWays")
    public List getAllInTwoWays(@RequestBody int tag){
        if(tag==1)
            return blogService.getAllOrderByDate();
        else if(tag==0)
            return blogService.getAllOrderByPv();

        return null;
    }

    @RequestMapping("/getAllSBT")
    public List getAllSortByTime(){
        return blogService.getAllOrderByDate();
    }

    @RequestMapping("/getAllSBPV")
    public List getAllSortByPv(){
        return blogService.getAllOrderByPv();
    }

    @RequestMapping("/getSomeSBT")
    public List getSomeSortByTime(@RequestBody int num){
        return blogService.getSomeOrderByPv(num);
    }

    @RequestMapping("/getSomeSBPV")
    public List getSomeSortByPv(@RequestBody int num){
        return blogService.getSomeOrderByPv(num);
    }

    @RequestMapping("/fuzzyQuery")
    public List fuzzyQueryAll(@RequestBody String input){
        return blogService.fuzzyQueryByBLoggerNameOrTitle(input);
    }

    @RequestMapping("/updateTitle")
    public boolean updateTitle(@RequestBody int id,@RequestBody String title){
        if(blogService.updateTitleById(title, id)){
            return true;
        }
        return false;
    }

    @RequestMapping("queryByBloggerId")
    public List queryByBloggerId(int order,String input,int bloggerId){
        return blogService.fuzzyQueryMyBlog(bloggerId,input,order);
    }


}
