package com.addr.model;

import java.util.ArrayList;

public interface SAddrDAO {
	// 추가
	public void addrInsert(AddrDTO addr);
	// 전체 보기
	public ArrayList<AddrDTO> addrList();
	// 상세 보기
	public AddrDTO addrDetail(int num);
	// 수정
	public void addrUpdate(AddrDTO addr);
	// 삭제
	public void addrDelete(int num);
	// 검색
	public ArrayList<AddrDTO> addrSearchList(String field, String word);
	// 개수
	public int addrCount();
	// 우편번호 검색
	public ArrayList<ZipDTO> addrZipRead(String dong);
	// file 추가
	public void fileInsert(FileDTO file);
	// file 추가
	public ArrayList<FileDTO> fileList();
}
