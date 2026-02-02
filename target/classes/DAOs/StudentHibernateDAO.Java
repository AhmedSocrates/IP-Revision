@Repository
public class StudentHibernateDAO extends HibernateDAO<Student> {
    @Autowired
    private SessionFactory sessionFactory; 

    @Transactional
    public void saveStudent(Student student){
        Session session = sessionFactory.getCurrentSession();
        session.save(student)
    }

    @Transactional 
    public List<Student> getAllStudents(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student", Student.class).getResultList();
    }

}