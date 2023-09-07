package com.reference.genai.sandbox.service;

import com.reference.genai.sandbox.model.Widget;
import com.reference.genai.sandbox.repository.WidgetRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WidgetService {

    @Autowired
    private WidgetRepository widgetRepository;

    public Widget createWidget(Widget widget) {
        return widgetRepository.save(widget);
    }

    public List<Widget> readWidgets() {
    Iterable<Widget> widgets = widgetRepository.findAll();
    return StreamSupport.stream(widgets.spliterator(), false)
                        .collect(Collectors.toList());
}

    public ResponseEntity<Widget> readWidget(Long id) {
        Optional<Widget> widget = widgetRepository.findById(id);
        if (widget.isPresent()) {
            return ResponseEntity.ok(widget.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Widget> updateWidget(Long id, Widget newWidget) {
        return widgetRepository.findById(id)
                .map(widget -> {
                    widget.setName(newWidget.getName());
                    widget.setDescription(newWidget.getDescription());
                    Widget updatedWidget = widgetRepository.save(widget);
                    return ResponseEntity.ok().body(updatedWidget);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteWidget(Long id) {
        if (widgetRepository.existsById(id)) {
            widgetRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}