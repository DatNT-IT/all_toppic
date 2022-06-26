package com.example.duanlon.service;

import com.example.duanlon.model.CriminalCase;

public interface ICriminalCaseService extends IAbstractService<CriminalCase> {
    CriminalCase createCriminalCase(CriminalCase criminalCase);
}
