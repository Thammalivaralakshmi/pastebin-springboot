package com.vara.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "pastes")
public class Paste {
	@Id
	@Column(length = 36)
	private String id;
	@Lob
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private Instant createdAt;
	private Instant expiresAt;
	private Integer maxViews;
	@Column(nullable = false)
	private Integer viewCount;

	// ----- getters and setters -----

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Instant expiresAt) {
		this.expiresAt = expiresAt;
	}

	public Integer getMaxViews() {
		return maxViews;
	}

	public void setMaxViews(Integer maxViews) {
		this.maxViews = maxViews;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
}
