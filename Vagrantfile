# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  
  config.vm.box = 'chef/centos-6.5'
  # The url from where the 'config.vm.box' box will be fetched if it
  # doesn't already exist on the user's system
  config.vm.box_url = 'http://vagrant.caringbridge.org/centos-chef.box'

  config.vm.network "forwarded_port", guest: 8080, host: 18080

  # Customize VM CPU and Memory
  config.vm.provider "virtualbox" do |v|
    v.memory = 1024
    v.cpus = 1
  end

  # Use ansible provisioner if it's installed on host, ansible_local if not.
  #if which('ansible-playbook')
  #	config.vm.provision "ansible" do |ans|
  #		ans.playbook = "provision/playbook.yml"
  #	    ans.verbose = true
  #	end
  #else
	  config.vm.provision "ansible_local" do |ans|
	    ans.playbook = "provision/playbook.yml"
	    ans.verbose = true
	    ans.install = true
	    ans.limit = "all"
	    ans.galaxy_role_file = "provision/requirements.txt"
	  end
   #end
   
end
