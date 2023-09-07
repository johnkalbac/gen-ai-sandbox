package com.reference.genai.sandbox.repository;

import com.reference.genai.sandbox.model.Widget;
import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository extends CrudRepository<Widget, Long> {
}