global_scripts = [
    'betteritemframes',
    'debugstick',
    'pillagerleash',
    'placeableplants',
    'prunedplants',
    'silkyblockstates',
    'skull',
    'specialnametags',
    'swapitem',
    'treecapitator',
    'villagerleash',
];

global_scriptpack = map(global_scripts, {'source' -> 'https://raw.githubusercontent.com/BisUmTo/scarpet/master/'+_+'.sc'});

__config() -> {
    'requires' -> {
        'carpet' -> '>=1.4.33',
        'minecraft' -> '>=1.17'
    },
    'command_permission' -> 'ops',
    'libraries' -> global_scriptpack,
    'commands' -> {
        'uninstall' -> 'uninstall'
    }
};

global_app_name = system_info('app_name');
print(format('l Script Pack "'+global_app_name+'" loaded'));

uninstall() -> (
    for(global_scripts,
        run('script remove '+_);
    );
    run('script remove '+global_app_name);
    run('script unload '+global_app_name);
    print(format('r Script Pack "'+global_app_name+'" uninstalled'))
);

__on_close() -> (
    for(global_scripts,
        run('script unload '+_);
    );
    print(format('r Script Pack "'+global_app_name+'" unloaded'))
)
