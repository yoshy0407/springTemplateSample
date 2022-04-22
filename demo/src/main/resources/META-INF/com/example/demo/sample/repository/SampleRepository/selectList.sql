SELECT
	/*%expand */*
FROM
	SAMPLE
WHERE
/*%if @isEmpty(name) */
	NAME LIKE /* @infix(name) */''
/*%end*/ 
ORDER BY 
	ID