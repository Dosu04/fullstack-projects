package com.dosu04.memoWebApp.repositories;

import com.dosu04.memoWebApp.models.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueReportRepository extends JpaRepository<IssueReport, Long> {


}
