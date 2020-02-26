<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>게시판</title>
<script>
</script>
</head>
	<div class="btn-group" >
		<button type="button" class="insert_btn btn btn-danger">신규</button>
		<button type="button" class="update_btn btn btn-warning">저장</button>
	</div>
	<form id="detail" class="form">
		<input type="hidden" id="iu" name="iu"></input>
		<div class="form-row">
			<div class="form-group row">
			    <div class="form-group col-md-6">
			    	<label for="advrtsEntrpsNm">광고업체명</label>
			    	<input type="text" class="form-control" id="advrtsEntrpsNm" name="advrtsEntrpsNm" placeholder="광고업체명"/>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="qrFileId">큐알코드</label>
			    	<input type="text" class="form-control" id="qrFileId" name="qrFileId" placeholder="큐알코드" />
			    	<button type="submit" class=" btn btn-primary">생성</button>
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group row">
			    <div class="form-group col-md-6">
			    	<label for="rprsntvNm">대표자명</label>
			    	<input type="text" class="form-control" id="rprsntvNm" name="rprsntvNm" placeholder="대표자명"/>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="advrtsEntrpsBizrno">사업자번호</label>
			    	<input type="text" class="form-control" id="advrtsEntrpsBizrno" name="advrtsEntrpsBizrno" placeholder="사업자번호">
			    </div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group row">
			    <div class="form-group col-md-6">
			    	<label for="entrpsTlphonNo">전화번호</label>
			    	<input type="text" class="form-control" id="entrpsTlphonNo" name="entrpsTlphonNo" placeholder="전화번호"/>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="entrpsMbtlnum">휴대전화</label>
			    	<input type="text" class="form-control" id="entrpsMbtlnum" name="entrpsMbtlnum" placeholder="휴대전화">
			    </div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group row">
			    <div class="form-group col-md-6">
			    	<label for="entrpsAtpt">시도</label>
			    	<select id="entrpsAtpt"  name="entrpsAtpt" class="form-control">
			        <option selected value="01">서울</option>
			        <option  value="02">경기</option>
			      </select>
			    </div>
			    <div class="form-group col-md-6">
			    	<label for="entrpsGuGun">구군</label>
			    	<select id="entrpsGuGun"  name="entrpsGuGun" class="form-control">
			        <option selected value="11110">중구</option>
			        <option selected value="11101">남구</option>
			      </select>
			    </div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group row">
				<div class="form-group col-md-10">
				    <label for="entrpsDetailAdres">상세주소</label>
				    <input type="text" class="form-control" id="entrpsDetailAdres" name="entrpsDetailAdres" placeholder="상세주소">
				</div>
			</div>
		</div>
	</form>
</html>