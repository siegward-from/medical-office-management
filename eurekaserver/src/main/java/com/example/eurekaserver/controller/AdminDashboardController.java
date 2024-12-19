package com.example.eurekaserver.controller;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
        Applications applications = registry.getApplications();
        
        model.addAttribute("applications", applications.getRegisteredApplications());
        model.addAttribute("totalInstances", applications.size());
        return "admin/dashboard";
    }

    @PostMapping("/services/{appId}/{instanceId}/remove")
    public String removeInstance(@PathVariable String appId, @PathVariable String instanceId) {
        PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
        registry.cancel(appId, instanceId, false);
        return "redirect:/admin/dashboard";
    }
} 