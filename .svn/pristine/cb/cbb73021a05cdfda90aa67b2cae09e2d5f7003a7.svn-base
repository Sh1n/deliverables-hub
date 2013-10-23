package com.gmail.shinsensei.deliverablesHub.logic;

import com.gmail.shinsensei.deliverablesHub.entities.Course;
import com.gmail.shinsensei.deliverablesHub.entities.Deliverable;
import com.gmail.shinsensei.deliverablesHub.entities.Project;
import com.gmail.shinsensei.deliverablesHub.logic.utils.HibernateUtil;
import com.gmail.shinsensei.deliverablesHub.utils.to.CourseTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.DeliverableTO;
import com.gmail.shinsensei.deliverablesHub.utils.to.ProjectTO;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *  Courses Bean
 * @author utente
 */
// TODO test
@Stateless
public class Courses implements CoursesLocal {

    private Session session;
    public Courses(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    @Override
    public CourseTO addCourse(CourseTO course) {
        try{
            Course tmp = new Course(course.getName(), course.getYear(), course.getSector(), course.getCode());
            Transaction tx = session.beginTransaction();
            session.save(tmp);
            session.flush();
            session.refresh(tmp);
            tx.commit();
            return new CourseTO(tmp);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    /**
     * 
     * @param courseId
     * @param professorId
     * @return 
     */
    @Override
    public boolean assignProfessorToCourse(int courseId, int professorId) {
        try{
            session.beginTransaction();
            List courses = session.createQuery("from courses where courseID = :courseId ").setParameter("courseId", courseId).list();
            if(courses.size() == 1){  // course found
                System.out.println("Course found, assigning professor");
                Query query = session.createQuery("insert into courses_professors(courseID, professorID)" +
    			"select courseID from courses where courseID = :courseID, userID from persons where userID = :professorID").setParameter("courseID", courseId).setParameter("professorID", professorId);
                int result = query.executeUpdate();
                session.flush();
                session.getTransaction().commit();
                return (result > 0) ? true : false;
            }else{
                System.out.println("Course not found");
                session.getTransaction().commit();
                return false;
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public List<CourseTO> listCourses() {
        List<CourseTO> courses = new LinkedList<CourseTO>();
        session.beginTransaction();
        Iterator iter = session.createCriteria(Course.class).list().iterator();
        while ( iter.hasNext() ) {
            System.out.println("Corso");
            courses.add(new CourseTO((Course) iter.next()));
        }
        session.getTransaction().commit();
        System.out.println(courses.toString());
        return courses;
    }

    /**
     * 
     * @param courseId
     * @return 
     */
    @Override
    public CourseTO viewCourse(int courseId) {
        session.beginTransaction();
        //Property courseIdProp = Property.forName(Course.COURSE_ID);
        List courses = session.createCriteria(Course.class)
                .setMaxResults(1)
                .add(Restrictions.eq("courseId", courseId)).list();
        CourseTO result = null;
        if(courses.size() == 1){  // course found
            System.out.println("Result found, build the course object");
            Course tmp = (Course)courses.get(0);
            tmp.getProjects();
            result = new CourseTO(tmp);
        }else{
            System.out.println("Course not found");
        }
        session.getTransaction().commit();
        return result;
         
    }
    /**
     * 
     * @param project
     * @return 
     */
    @Override
    public ProjectTO createProject(ProjectTO project) {
        try{
            session.beginTransaction();
            Property courseIdProp = Property.forName("courseId");
            List courses = session.createCriteria(Course.class).setMaxResults(1).add(courseIdProp.eq(project.getCourseId())).list();
            Course courseTmp = null;
            if(courses.size() == 1){  // course found
                System.out.println("Course found, build the project object");
                courseTmp = (Course) courses.get(0);
                
                Project projectTmp = new Project(courseTmp, project.getName(), project.getDescription());
     
                courseTmp.getProjects().add(projectTmp);
                
                session.save(projectTmp);
                session.flush();
                session.refresh(projectTmp);
                session.getTransaction().commit();
                return new ProjectTO(projectTmp);
            }else{
                System.out.println("Course not found");
                session.getTransaction().commit();
                return null;
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * 
     * @param deliverable
     * @return 
     */
    @Override
    public DeliverableTO createDeliverable(DeliverableTO deliverable) {
        try{
            session.beginTransaction();
            Property projectIdProp = Property.forName("projectId");
            List courses = session.createCriteria(Project.class).setMaxResults(1).add(projectIdProp.eq(deliverable.getProjectID())).list();
            Project projectTmp = null;
            if(courses.size() == 1){  // project found
                System.out.println("Project found, build the project object");
                projectTmp = (Project) courses.get(0);
                
                Deliverable delTmp = new Deliverable(projectTmp, deliverable.getName(), deliverable.getDeadline());
                session.save(delTmp);
                session.flush();
                session.refresh(delTmp);
                session.getTransaction().commit();
                return new DeliverableTO(delTmp);
            }else{
                System.out.println("Project not found");
                session.getTransaction().commit();
                return null;
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
    
}
