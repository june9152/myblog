package com.sprata.myblog.service;

import com.sprata.myblog.dto.CommentRequestDto;
import com.sprata.myblog.dto.CommentResponseDto;
import com.sprata.myblog.entity.Comment;
import com.sprata.myblog.entity.User;
import com.sprata.myblog.entity.UserRoleEnum;
import com.sprata.myblog.jwt.JwtUtil;
import com.sprata.myblog.repository.CommentRepository;
import com.sprata.myblog.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    //
    private final CommentRepository CommentRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public CommentResponseDto createComment(Long postId,CommentRequestDto requestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        // 토큰이 있는 경우에만 관심상품 추가 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            // 요청받은 DTO 로 DB에 저장할 객체 만들기
            Comment comment = CommentRepository.saveAndFlush(new Comment(requestDto,user.getId(),postId));

            return new CommentResponseDto(comment);
        } else {
            return null;
        }
    }
    @Transactional(readOnly = true)
    public List<CommentResponseDto> getComment(HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        // 토큰이 있는 경우에만 관심상품 조회 가능
        if (token != null) {
            // Token 검증
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            // 사용자 권한 가져와서 ADMIN 이면 전체 조회, USER 면 본인이 추가한 부분 조회
            UserRoleEnum userRoleEnum = user.getRole();
            System.out.println("role = " + userRoleEnum);

            List<CommentResponseDto> list = new ArrayList<>();
            List<Comment> CommentList;

            if (userRoleEnum == UserRoleEnum.USER) {
                // 사용자 권한이 USER일 경우
                CommentList = CommentRepository.findAllByUserId(user.getId());
            } else {
                CommentList = CommentRepository.findAll();
            }

            for (Comment product : CommentList) {
                list.add(new CommentResponseDto(product));
            }

            return list;

        } else {
            return null;
        }
    }

    @Transactional
    public CommentResponseDto updateComment(Long id,CommentRequestDto requestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        // 토큰이 있는 경우에만 관심상품 추가 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            // 요청받은 DTO 로 DB에 저장할 객체 만들기
            /*
             * 영속성 컨텍스트으로 인한 자동 변환...
             * */
            Comment Comment = CommentRepository.findById(id).orElseGet(Comment::new);
            Comment.Update(requestDto);
            return new CommentResponseDto(Comment);
        } else {
            return null;
        }
    }
    @Transactional
    public CommentResponseDto deleteComment(Long id,CommentRequestDto requestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        // 토큰이 있는 경우에만 관심상품 추가 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            // 요청받은 DTO 로 DB에 저장할 객체 만들기
            /*
             * 영속성 컨텍스트으로 인한 자동 변환...
             * */
            Comment Comment = CommentRepository.findById(id).orElseGet(Comment::new);
            CommentRepository.delete(Comment);
            return new CommentResponseDto(Comment);
        } else {
            return null;
        }
    }
}
