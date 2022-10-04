package com.poly.service;

import com.poly.request.AuthorityRequest;
import com.poly.response.AuthorityResponse;

import java.util.List;

public interface AuthorityService {

 List<AuthorityResponse> findAll();

 AuthorityResponse create(AuthorityRequest request);


 List<AuthorityResponse> findAuthoritiesOfAdminstrators();

 void delete(Integer id);


}
