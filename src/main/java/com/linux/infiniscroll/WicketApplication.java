package com.linux.infiniscroll;


import static org.springframework.web.context.support.WebApplicationContextUtils.getWebApplicationContext;

import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.linux.infiniscroll.wicket.page.ShowDataTablePage;
import com.linux.infiniscroll.wicket.page.dataentry.HomePage;
import com.linux.infiniscroll.wicket.page.selected.ShowSelectedDataPage;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.themes.bootstrap.BootstrapTheme;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.SingleThemeProvider;

public class WicketApplication extends WebApplication {
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	@Override
	public void init() {
		super.init();
		
		mount(new MountedMapper("/", HomePage.class));
		mount(new MountedMapper("/showData", ShowDataTablePage.class));
		mount(new MountedMapper("/showSelected", ShowSelectedDataPage.class));

		getComponentInstantiationListeners()
				.add(new SpringComponentInjector(this, getWebApplicationContext(getServletContext())));

		Bootstrap.install(this,
				new BootstrapSettings().setThemeProvider(new SingleThemeProvider(new BootstrapTheme())));
	}
}
