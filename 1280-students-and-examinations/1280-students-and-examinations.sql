# Write your MySQL query statement below
 with ct as(select *
from students
cross join subjects
)
select ct.student_id,ct.student_name,ct.subject_name,
sum(case when e.subject_name is null then 0 else 
1 end )as attended_exams
from ct
left join examinations e on 
ct.student_id = e.student_id and ct.subject_name = e.subject_name
group by ct.student_id,ct.student_name ,ct.subject_name
order by ct.student_id ,ct.subject_name;



